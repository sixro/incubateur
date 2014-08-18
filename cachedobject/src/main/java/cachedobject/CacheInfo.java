package cachedobject;

import java.util.Date;

class CacheInfo {

    private final Date validity;
    private final Object object;

    public CacheInfo(Date validity, Object object) {
        this.validity = validity;
        this.object = object;
    }

    public Date getValidityEnd() {
        return validity;
    }

    public Object getObject() {
        return object;
    }

}
