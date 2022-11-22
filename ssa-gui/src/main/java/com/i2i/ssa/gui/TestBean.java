package com.i2i.ssa.gui;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import org.springframework.stereotype.Controller;

@Controller
@ViewScoped
public class TestBean implements Serializable {

  public String getHelloWorld() {
    return "Hello world!";
  }

}
