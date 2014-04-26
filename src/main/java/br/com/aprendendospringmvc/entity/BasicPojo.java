package br.com.aprendendospringmvc.entity;

import java.io.Serializable;

/**
 * Created by ellison on 25/04/14.
 */
public interface BasicPojo extends Serializable {

    public static final BasicPojo NULL = () -> Long.MIN_VALUE;

    Long getId();

}
