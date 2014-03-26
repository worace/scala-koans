package org.functionalkoans.forscala

import org.scalatest.matchers.ShouldMatchers
import support.KoanSuite

class AboutMethods extends KoanSuite with ShouldMatchers {

  class AboutConstructorWithValParameter(val name: String) {
  }

  koan("methods with same name but different input type are different") {
    class MyClass {
      def foo(bar: Int) = bar + 1
      def foo(bar: String) = bar.reverse
    }

    val myInstance = new MyClass
    myInstance.foo(1) should be(2)
    myInstance.foo("pizza") should be("azzip")
  }
  koan("methods with same name, same input type, but different return type are the same") {
    class MyClass {
      def foo(bar: Int): Int = bar + 1
      // wont compile -- cant be defined twice
      //def foo(bar: Int): String = bar.toString
    }
  }
}

