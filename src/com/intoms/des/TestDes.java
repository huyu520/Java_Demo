/**
 * 
 */
package com.intoms.des;

import org.bouncycastle.util.encoders.Hex;

import com.intoms.util.crypt.DESCoder;
import com.intoms.util.log.ILog;

/**
 *  CopyRight by 2016 Mfish
 *  All Right Reserved
 *	
 *  @author hy
 *	Create on 2016年11月30日下午12:03:58
 */
public class TestDes {
	public static final byte[] CLINET_CRYPT_KEY = "KZrlo^1fcyJm<*nM_A97^$24".getBytes();    
	private static DESCoder des = null;
	
	static{
		try
        {
            des = new DESCoder(CLINET_CRYPT_KEY);
        }
        catch(Exception e)
        {
            ILog.getFatal().fatal("",e);
			System.exit( -1 );
        }
	}
	
	public static void main(String[] args)  {
		System.out.println(Hex.decode("361643f832a0fde2db46f7e893c05932").toString());
	}
}
