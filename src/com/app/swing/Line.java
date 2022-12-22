package com.app.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Line extends JPanel{

     @Override public void paint(Graphics g)
     {
         //Get the current size of this component
         Dimension d = this.getSize();

         //draw in black
         g.setColor(new Color(242,242,242));
         //draw a centered horizontal line
         g.drawLine(0,d.height/2,d.width,d.height/2);
     }
}    

