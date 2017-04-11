package src.com.intoms;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AnalysisUserDiffByDay {

	private static final String ROOT_PATH = "/data/mqq_data/log_center/silly/tools/dolphinInfo/sourceData/";
	  private static final int[] chargeStage = { 10, 50, 500, 2000, 5000, 20000, 50000, 100000 };

	  private static Map<String, Integer> date1LevelMap = new HashMap();
	  private static Map<String, Integer> date2LevelMap = new HashMap();
	  private static Map<String, Integer> date1ChargeMap = new HashMap();
	  private static Map<String, Integer> date2ChargeMap = new HashMap();

	  private static Map<String, String> levelResultMap = new LinkedHashMap();
	  private static Map<String, String> chargeResultMap = new LinkedHashMap();

	  public static void main(String[] args) {
	    String date1 = args[0];
	    String date2 = args[1];
	    int minLevel = 150;
	    int minCharge = 5000;
	    if (args.length >= 4) {
	      minLevel = Integer.parseInt(args[2]);
	      minCharge = Integer.parseInt(args[3]);
	    }

	    String file1 = "/data/mqq_data/log_center/silly/tools/dolphinInfo/sourceData/" + date1 + ".access";
	    String file2 = "/data/mqq_data/log_center/silly/tools/dolphinInfo/sourceData/" + date2 + ".access";

	    readFile(file1, minLevel, minCharge, date1LevelMap, date1ChargeMap);
	    readFile(file2, minLevel, minCharge, date2LevelMap, date2ChargeMap);

	    diffLevel(minLevel);
	    diffCharge(minCharge);

	    printResult(date2);
	  }

	  public static void printResult(String judgeDate) {
	    System.out.println(judgeDate);
	    for (String key : levelResultMap.keySet()) {
	      String value = (String)levelResultMap.get(key);
	      key = key + value.split("\\|").length;
	      System.out.println(key + ":" + value);
	    }
	    for (String key : chargeResultMap.keySet()) {
	      String value = (String)chargeResultMap.get(key);
	      key = key + value.split("\\|").length;
	      System.out.println(key + ":" + value);
	    }
	  }

	  public static void readFile(String fileName, int minLeve, int minCharge, Map<String, Integer> levelMap, Map<String, Integer> chargeMap)
	  {
	    BufferedReader br = null;
	    try {
	      br = new BufferedReader(new FileReader(new File(fileName)));
	      String readLine = null;
	      while ((readLine = br.readLine()) != null) {
	        String[] info = readLine.split("\\|", 3);

	        String uid = info[0];
	        int level = 0;
	        if ((info[1] != null) && (info[1].trim().length() > 0)) {
	          level = Integer.parseInt(info[1]);
	        }
	        int charge = 0;
	        if ((info[2] != null) && (info[2].trim().length() > 0)) {
	          charge = Integer.parseInt(info[2]);
	        }

	        Integer oldLevel = (Integer)levelMap.get(uid);
	        if ((oldLevel == null) || (level > oldLevel.intValue())) {
	          levelMap.put(uid, Integer.valueOf(level));
	        }

	        Integer oldCharge = (Integer)chargeMap.get(uid);
	        if ((oldCharge == null) || (charge > oldCharge.intValue()))
	          chargeMap.put(uid, Integer.valueOf(charge));
	      }
	    }
	    catch (Exception e)
	    {
	      System.err.println("ERROR:read file[" + fileName + "] fail!" + e.getMessage());

	      if (br != null)
	        try {
	          br.close();
	        } catch (IOException e1) {
	          System.err.println("ERROR:close file[" + fileName + "] fail!" + e1.getMessage());
	        }
	    }
	    finally
	    {
	      if (br != null)
	        try {
	          br.close();
	        } catch (IOException e) {
	          System.err.println("ERROR:close file[" + fileName + "] fail!" + e.getMessage());
	        }
	    }
	  }

	  public static void diffLevel(int minLevel)
	  {
	    for (String uid1 : date1LevelMap.keySet()) {
	      Integer level1 = (Integer)date1LevelMap.get(uid1);
	      Integer level2 = (Integer)date2LevelMap.get(uid1);

	      if ((level1.intValue() > minLevel) || ((level2 != null) && (level2.intValue() > minLevel)))
	      {
	        if (level2 != null) {
	          boolean hasInSameStage = (level1.intValue() - 1) / 10 == (level2.intValue() - 1) / 10;
	          if (!hasInSameStage)
	          {
	            String key = (level2.intValue() - 1) / 10 * 10 + 1 + "级以上+";
	            String value = (String)levelResultMap.get(key);
	            value = value + "|" + uid1 + "(升级)";
	            levelResultMap.put(key, value);
	          }
	        }
	        else {
	          String key = (level1.intValue() - 1) / 10 * 10 + 1 + "级以上-";
	          String value = (String)levelResultMap.get(key);
	          value = value + "|" + uid1;
	          levelResultMap.put(key, value);
	        }
	      }
	    }
	    for (String uid2 : date2LevelMap.keySet()) {
	      Integer level1 = (Integer)date1LevelMap.get(uid2);
	      Integer level2 = (Integer)date2LevelMap.get(uid2);
	      if ((level1 == null) && (level2.intValue() > minLevel))
	      {
	        String key = (level2.intValue() - 1) / 10 * 10 + 1 + "级以上+";
	        String value = (String)levelResultMap.get(key);
	        value = value + "|" + uid2;
	        levelResultMap.put(key, value);
	      }
	    }
	  }

	  public static void diffCharge(int minCharge)
	  {
	    for (String uid1 : date1ChargeMap.keySet()) {
	      Integer charge1 = (Integer)date1ChargeMap.get(uid1);
	      Integer charge2 = (Integer)date2ChargeMap.get(uid1);

	      if ((charge1.intValue() > minCharge) || ((charge2 != null) && (charge2.intValue() > minCharge)))
	      {
	        if (charge2 != null) {
	          boolean hasInSameStage = hasInSameStage(charge1.intValue(), charge2.intValue(), chargeStage);
	          if (!hasInSameStage)
	          {
	            String key = getStage(charge2.intValue(), chargeStage) + "以上+";
	            String value = (String)chargeResultMap.get(key);
	            value = value + "|" + uid1 + "(升级)";
	            chargeResultMap.put(key, value);
	          }
	        }
	        else {
	          String key = getStage(charge1.intValue(), chargeStage) + "以上-";
	          String value = (String)chargeResultMap.get(key);
	          value = value + "|" + uid1;
	          chargeResultMap.put(key, value);
	        }
	      }
	    }
	    for (String uid2 : date2ChargeMap.keySet()) {
	      Integer charge1 = (Integer)date1ChargeMap.get(uid2);
	      Integer charge2 = (Integer)date2ChargeMap.get(uid2);
	      if ((charge1 == null) && (charge2.intValue() > minCharge))
	      {
	        String key = getStage(charge2.intValue(), chargeStage) + "以上+";
	        String value = (String)chargeResultMap.get(key);
	        value = value + "|" + uid2;
	        chargeResultMap.put(key, value);
	      }
	    }
	  }

	  public static boolean hasInSameStage(int no1, int no2, int[] stage)
	  {
	    boolean hasIn = false;
	    for (int i = 0; i < stage.length; i++) {
	      if ((no1 <= stage[i]) && (no2 <= stage[i])) {
	        hasIn = true;
	        break;
	      }if ((no1 <= stage[i]) && (no2 > stage[i])) {
	        hasIn = false;
	        break;
	      }if ((no1 > stage[i]) && (no2 <= stage[i])) {
	        hasIn = false;
	        break;
	      }
	    }
	    return hasIn;
	  }

	  public static int getStage(int value, int[] stage) {
	    int index = -1;
	    for (int i = stage.length - 1; i >= 0; i--) {
	      if (value > stage[i]) {
	        index = i;
	        break;
	      }
	    }

	    if (index != -1) {
	      return stage[index];
	    }

	    return 0;
	  }
}
