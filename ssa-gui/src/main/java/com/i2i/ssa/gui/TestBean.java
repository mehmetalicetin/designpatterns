package com.i2i.ssa.gui;

import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Controller
@ViewScoped
public class TestBean implements Serializable {

  public String getHelloWorld() {
    return "Hello world!";
  }

}
