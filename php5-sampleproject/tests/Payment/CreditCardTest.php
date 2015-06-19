<?php

namespace Payment;

class CreditCardTest extends \PHPUnit_Framework_TestCase {

    public function testBin() {
        $creditCard = new CreditCard("1234560011112222", "12/2018", "999");
        $this->assertEquals("123456", $creditCard->bin());
    }

}
