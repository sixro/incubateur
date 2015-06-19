<?php

namespace Payment;

class CreditCard {

    private $_pan;
    private $_expire;
    private $_cvv;

    public function __construct($pan, $expire, $cvv) {
        $this->_pan = $pan;
        $this->_expire = $expire;
        $this->_cvv = $cvv;
    }

    public function bin() {
        return substr($this->_pan, 0, 6);
    }

}
