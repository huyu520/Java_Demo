package src.com.intoms;


/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class AnalysisUserDiffByCycle
/*     */ {
/*     */   private static final String ROOT_PATH = "/data/mqq_data/log_center/silly/tools/dolphinInfo/sourceData/";
/*  17 */   private static Map<String, Integer> cycle1LevelMap = new HashMap();
/*  18 */   private static Map<String, Integer> cycle1ChargeMap = new HashMap();
/*  19 */   private static Map<String, Integer> cycle1LoginNumMap = new HashMap();
/*  20 */   private static Map<String, Integer> cycle2LevelMap = new HashMap();
/*  21 */   private static Map<String, Integer> cycle2ChargeMap = new HashMap();
/*  22 */   private static Map<String, Integer> cycle2LoginNumMap = new HashMap();
/*  24 */   private static Map<String, Integer> tempMap = new HashMap();
/*  26 */   private static Map<String, String> aseResultMap = new LinkedHashMap();
/*  27 */   private static Map<String, String> descResultMap = new LinkedHashMap();
/*     */   
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/*  30 */     String date1_start = args[0];
/*  31 */     String date1_end = args[1];
/*  32 */     String date2_start = args[2];
/*  33 */     String date2_end = args[3];
/*     */     
/*  35 */     int minLevel = 140;
/*  36 */     int minCharge = 5000;
/*  37 */     if (args.length >= 5) {
/*  38 */       minLevel = Integer.parseInt(args[4]);
/*     */     }
/*  40 */     if (args.length >= 6) {
/*  41 */       minCharge = Integer.parseInt(args[5]);
/*     */     }
/*  44 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*     */     
/*  46 */     Calendar start_1 = Calendar.getInstance();
/*  47 */     start_1.setTime(sdf.parse(date1_start));
/*  48 */     Calendar end_1 = Calendar.getInstance();
/*  49 */     end_1.setTime(sdf.parse(date1_end));
/*  50 */     Calendar start_2 = Calendar.getInstance();
/*  51 */     start_2.setTime(sdf.parse(date2_start));
/*  52 */     Calendar end_2 = Calendar.getInstance();
/*  53 */     end_2.setTime(sdf.parse(date2_end));
/*  55 */     for (int i = 1; (!start_1.after(end_1)) && (i <= 31); start_1.add(5, 1))
/*     */     {
/*  56 */       String file1 = "/data/mqq_data/log_center/silly/tools/dolphinInfo/sourceData/" + sdf.format(start_1.getTime()) + ".access";
/*  57 */       readFile(file1, minLevel, minCharge, cycle1LevelMap, cycle1ChargeMap, cycle1LoginNumMap);
/*     */       
/*  59 */       i++;
/*     */     }
/*  62 */     for (int i = 1; (!start_2.after(end_2)) && (i <= 31); start_2.add(5, 1))
/*     */     {
/*  63 */       String file2 = "/data/mqq_data/log_center/silly/tools/dolphinInfo/sourceData/" + sdf.format(start_2.getTime()) + ".access";
/*  64 */       readFile(file2, minLevel, minCharge, cycle2LevelMap, cycle2ChargeMap, cycle2LoginNumMap);
/*     */       
/*  66 */       i++;
/*     */     }
/*  69 */     diff(minLevel, minCharge);
/*  70 */     printResult(date2_start, date2_end);
/*     */   }
/*     */   
/*     */   public static void readFile(String fileName, int minLeve, int minCharge, Map<String, Integer> levelMap, Map<String, Integer> chargeMap, Map<String, Integer> loginNumMap)
/*     */   {
/*  75 */     tempMap.clear();
/*  76 */     BufferedReader br = null;
/*     */     try
/*     */     {
/*  78 */       br = new BufferedReader(new FileReader(new File(fileName)));
/*  79 */       String readLine = null;
/*  80 */       while ((readLine = br.readLine()) != null)
/*     */       {
/*  81 */         String[] info = readLine.split("\\|", 3);
/*     */         
/*  83 */         String uid = info[0];
/*  84 */         int level = 0;
/*  85 */         if ((info[1] != null) && (info[1].trim().length() > 0)) {
/*  86 */           level = Integer.parseInt(info[1]);
/*     */         }
/*  88 */         int charge = 0;
/*  89 */         if ((info[2] != null) && (info[2].trim().length() > 0)) {
/*  90 */           charge = Integer.parseInt(info[2]);
/*     */         }
/*  93 */         Integer oldLevel = (Integer)levelMap.get(uid);
/*  94 */         if ((oldLevel == null) || (level > oldLevel.intValue())) {
/*  95 */           levelMap.put(uid, Integer.valueOf(level));
/*     */         }
/*  98 */         Integer oldCharge = (Integer)chargeMap.get(uid);
/*  99 */         if ((oldCharge == null) || (charge > oldCharge.intValue())) {
/* 100 */           chargeMap.put(uid, Integer.valueOf(charge));
/*     */         }
/* 103 */         if (!tempMap.containsKey(uid))
/*     */         {
/* 104 */           tempMap.put(uid, Integer.valueOf(0));
/* 105 */           Integer oldNum = (Integer)loginNumMap.get(uid);
/* 106 */           loginNumMap.put(uid, Integer.valueOf(oldNum == null ? 1 : oldNum.intValue() + 1));
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 110 */       System.err.println("ERROR:read file[" + fileName + "] fail!" + e.getMessage());
/* 112 */       if (br != null) {
/*     */         try
/*     */         {
/* 114 */           br.close();
/*     */         }
/*     */         catch (IOException e1)
/*     */         {
/* 116 */           System.err.println("ERROR:close file[" + fileName + "] fail!" + e1.getMessage());
/*     */         }
/*     */       }
/* 121 */       if (br != null) {
/*     */         try
/*     */         {
/* 123 */           br.close();
/*     */         }
/*     */         catch (IOException e1)
/*     */         {
/* 125 */           System.err.println("ERROR:close file[" + fileName + "] fail!" + e.getMessage());
/*     */         }
/*     */       }
/*     */     }
/*     */     finally
/*     */     {
/* 121 */       if (br != null) {
/*     */         try
/*     */         {
/* 123 */           br.close();
/*     */         }
/*     */         catch (IOException e)
/*     */         {
/* 125 */           System.err.println("ERROR:close file[" + fileName + "] fail!" + e.getMessage());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void diff(int minLevel, int minCharge)
/*     */   {
/* 132 */     List<String> allList = new ArrayList();
/* 133 */     allList.addAll(cycle1LoginNumMap.keySet());
/* 134 */     allList.addAll(cycle2LoginNumMap.keySet());
/* 135 */     for (String uid1 : allList)
/*     */     {
/* 136 */       int cycle1Level = cycle1LevelMap.get(uid1) == null ? 0 : ((Integer)cycle1LevelMap.get(uid1)).intValue();
/* 137 */       int cycle1Charge = cycle1ChargeMap.get(uid1) == null ? 0 : ((Integer)cycle1ChargeMap.get(uid1)).intValue();
/* 138 */       int cycle2Level = cycle2LevelMap.get(uid1) == null ? 0 : ((Integer)cycle2LevelMap.get(uid1)).intValue();
/* 139 */       int cycle2Charge = cycle2ChargeMap.get(uid1) == null ? 0 : ((Integer)cycle2ChargeMap.get(uid1)).intValue();
/* 141 */       if ((cycle1Level > minLevel) || (cycle2Level > minLevel) || 
/* 142 */         (cycle1Charge > minCharge) || (cycle2Charge > minCharge))
/*     */       {
/* 144 */         int loginNum1 = cycle1LoginNumMap.get(uid1) == null ? 0 : ((Integer)cycle1LoginNumMap.get(uid1)).intValue();
/* 145 */         int loginNum2 = cycle2LoginNumMap.get(uid1) == null ? 0 : ((Integer)cycle2LoginNumMap.get(uid1)).intValue();
/* 147 */         if (loginNum1 > loginNum2) {
/* 148 */           descResultMap.put(uid1, loginNum1 + "\t" + loginNum2 + "\t" + cycle1Level + "\t" + cycle1Charge + "\t" + cycle2Level + "\t" + cycle2Charge);
/* 149 */         } else if (loginNum1 < loginNum2) {
/* 150 */           aseResultMap.put(uid1, loginNum1 + "\t" + loginNum2 + "\t" + cycle1Level + "\t" + cycle1Charge + "\t" + cycle2Level + "\t" + cycle2Charge);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void printResult(String judgeStart, String judgeEnd)
/*     */   {
/* 156 */     System.out.println(judgeStart + "~" + judgeEnd);
/* 157 */     System.out.println("类别\tuid\t上周登录天数\t本周登录天数\t上周最高等级\t上周累计额度\t本周最高等级\t本周累计额度");
/* 158 */     for (String uid : descResultMap.keySet()) {
/* 159 */       System.out.println("减少\t" + uid + "\t" + (String)descResultMap.get(uid));
/*     */     }
/* 161 */     for (String uid : aseResultMap.keySet()) {
/* 162 */       System.out.println("增加\t" + uid + "\t" + (String)aseResultMap.get(uid));
/*     */     }
/*     */   }
/*     */ }


/* Location:           C:\Users\Administrator\Desktop\
 * Qualified Name:     com.mfish.dolphin.analysis.AnalysisUserDiffByCycle
 * JD-Core Version:    0.7.0.1
 */