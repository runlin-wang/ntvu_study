package com.ntvu.web2.util;

public class Tools {

    /**
     * 判断：给定的身份证号是否合法，不合法，抛出异常
     * @param idCard
     * @throws Exception
     */
    public static void validateIDCard(String idCard) throws Exception
    {
        if(idCard.length() != 18)
        {
            throw new Exception("身份证号长必须为18位");
        }
        for(int index = 0; index < idCard.length() ; index ++)
        {
            if(idCard.charAt(index) >= '0' && idCard.charAt(index) <= '9')
            {
                continue;
            }else{
                if(index == 17 && (idCard.charAt(index) == 'x' || idCard.charAt(index) == 'X' ) )
                {
                    continue;
                }else {
                    throw new Exception("身份证号长必须为18位,且是数字，最后一位可为x");
                }
            }
        }
    }
}
