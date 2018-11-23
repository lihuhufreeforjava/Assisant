/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.children.annotation;

import java.lang.annotation.*;

/**
 *
 * @author wb-lcj442691
 * @version $Id: ValidateMsg.java, v 0.1 2018年11月14日 9:27 wb-lcj442691 Exp $
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
@Inherited
public @interface ValidatorDesc {
    /**
     * 校验结果code
     * @return
     */
    Integer  code=null;

    /**
     *  结果message
     * @return
     */
    String message=null;

}