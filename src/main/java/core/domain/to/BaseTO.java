package core.domain.to;

import core.HasId;

public abstract class BaseTO implements HasId{
    private Integer  id;

    public BaseTO() {
    }

    public BaseTO(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
