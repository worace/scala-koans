package org.functionalkoans.forscala

import org.scalatest.matchers.ShouldMatchers
import support.KoanSuite

class AboutConstructors extends KoanSuite with ShouldMatchers {

  class AboutConstructorWithValParameter(val name: String) {
    // invoke auxilary constructor
    def this() {
      // what happens if you comment out the following line?
      this ("defaultname")
    }
  }

  class AboutClassWithNoClassParameter {
  }

  class AboutConstructorWithVarParameter(var name: String) {
  }

  class AboutConstructorWithPrivateClassParameter(name: String) {
  }

  koan("val in class definition defines read only property") {
    val aboutMe = new AboutConstructorWithValParameter("MyName")
    aboutMe.name should be("MyName")
    // wont compile:
    //aboutMe.name = "pizza"
  }

  koan("var in class definition defines read/write parameters") {
    val aboutMe = new AboutConstructorWithVarParameter("MyName")
    aboutMe.name = "YourName"
    aboutMe.name should be("YourName")
  }

  koan("private member data is not accessible") {
    val aboutMe = new AboutConstructorWithPrivateClassParameter("MyName")


     // wont compile:
     //aboutMe.name should be("MyName")
  }

  koan("private member data can be exposed by manual accessor") {
    class AboutConstructorWithPrivateClassParameterAndAccessor(name: String) {
      def getName: String = this.name
    }
    val aboutMe = new AboutConstructorWithPrivateClassParameterAndAccessor("MyName")
    aboutMe.getName should be("MyName")
  }

  koan("Primary constructor specified with a parameter requires that parameter to be passed in") {
     val aboutMe = new AboutConstructorWithValParameter()
     aboutMe.name should be("defaultname") //uses default name value
  }

  koan("Class with no class parameters is called with no arguments") {
    // add parameter to make this fail
    val aboutMe = new AboutClassWithNoClassParameter
  }
}
