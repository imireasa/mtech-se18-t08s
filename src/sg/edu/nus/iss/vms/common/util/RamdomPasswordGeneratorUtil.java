/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.vms.common.util;

import com.Ostermiller.util.RandPass;
import java.security.SecureRandom;

/**
 *
 * @author zaw
 */
public class RamdomPasswordGeneratorUtil {

        public static String getPassword(int length) throws Exception {
                SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
                byte[] aesKey = new byte[16]; // 16 bytes = 128 bits

                random.nextBytes(aesKey);
                String newPassword = new RandPass(random).getPass(length);
                return newPassword;
        }
}
