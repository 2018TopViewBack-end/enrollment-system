package org.topview.config.exception;

/**
 * 当注册失败时，将抛出该异常
 * @author 63023
 */
public class RegisterFailException extends Exception{
    /**
     * 说明异常
     */
    public RegisterFailException(){
        super("对不起,注册失败");
    }
}
