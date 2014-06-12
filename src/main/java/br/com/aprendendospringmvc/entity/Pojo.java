package br.com.aprendendospringmvc.entity;

/**
 * Created by ellison on 25/04/14.
 */
public interface Pojo extends BasicPojo {

    public static final Pojo NULL = new Pojo() {
        @Override
        public void setId(Long id) {
            // not implemented
        }

        @Override
        public Long getId() {
            return Long.MIN_VALUE;
        }
    };

    void setId(Long id);

}
