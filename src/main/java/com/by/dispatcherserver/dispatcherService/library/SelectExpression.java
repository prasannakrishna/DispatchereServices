/**
 * 
 */
package com.by.dispatcherserver.dispatcherService.library;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
/**
 * @author 1019092
 *
 */
public @interface SelectExpression {

	String Value();
}
