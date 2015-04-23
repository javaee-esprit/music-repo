package org.esprit.javaee.client;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

@Retention(RUNTIME)
@Target({METHOD,TYPE,FIELD})
public @interface Loggable {

}
