package juit.Components;

import juit.Layouts.*;
import juit.utils.Clock.Clock;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;

public class Window extends JComponent{
    static final public byte EXIT_ON_CLOSE = JFrame.EXIT_ON_CLOSE;
    static final public byte DO_NOTHING_ON_CLOSE = JFrame.DO_NOTHING_ON_CLOSE;
    static final public byte HIDE_ON_CLOSE = JFrame.HIDE_ON_CLOSE;
    static final public byte DISPOSE_ON_CLOSE = JFrame.DISPOSE_ON_CLOSE;
    int SizeX,SizeY,PositionX,PositionY;
    JFrame window = new JFrame();

    public void createWindow(String Title, int SizeX, int SizeY)
    {
        window.setTitle(Title);
        window.setVisible(true);
        window.setSize(SizeX,SizeY);
        this.SizeX = SizeX;
        this.SizeY = SizeY;
    }

    public void add(Button button)
    {
        window.add(button.jButton);
    }
    public void add(Label label)
    {
        window.add(label.label);
    }

    public JFrame getWindow() {
        return window;
    }
    public void setCloseOperation(int WindowNumber)
    {
        if(WindowNumber == Window.DO_NOTHING_ON_CLOSE) window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        if(WindowNumber == Window.HIDE_ON_CLOSE) window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        if(WindowNumber == Window.DISPOSE_ON_CLOSE) window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(WindowNumber == Window.EXIT_ON_CLOSE) window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public int GetX(){return SizeX;}
    public int GetY() {return SizeY;}
    public void add(Clock clock)
    {
        if(clock.getClockType().equals("Digital"))window.add(clock.getDigitalClock());
        if(clock.getClockType().equals("Analog"))window.add(clock.getAnalogClock());
    }
    public void add(Spinner spinner)
    {
        window.add(spinner.jSpinner);
    }
    public void add(CheckBox checkBox)
    {
        window.add(checkBox.jCheckBox);
    }
    public void add(MenuBar menuBar)
    {
        window.add(menuBar.menuBar);
    }
    public void add(PasswordField passwordField)
    {
        window.add(passwordField.jPasswordField);
    }
    public void add(Slider slider)
    {
        window.add(slider.jSlider);
    }
    public void add(TextField textField)
    {
        window.add(textField.jTextField);
    }
    public void add(ToggleSwitch toggleSwitch)
    {
        window.add(toggleSwitch.jToggleButton);
    }
    public void add(Panel panel)
    {
        window.add(panel.jPanel);
    }
    public void setLayout(FlowLayouts flowLayouts)
    {
        window.setLayout(flowLayouts.flowLayout);
    }
    public void setLayout(AbsoluteLayout absoluteLayout)
    {
        window.setLayout((LayoutManager) absoluteLayout.getLayout());
    }
    public void setLayout(BoxLayouts boxLayouts,Container pane,int AXIS)
    {
        window.setLayout(boxLayouts.getBoxLayout(pane,AXIS));
        if(AXIS != BoxLayouts.X_AXIS &&AXIS != BoxLayouts.Y_AXIS) throw new InvalidParameterException("setLayout()" +
                " Function AXIS Parameter Which is Invalid. Try To use'BoxLayouts.Y_AXIS' or 'BoxLayouts.X_AXIS'");
    }
    public void setLayout(CardLayouts cardLayouts)
    {
        window.setLayout(cardLayouts.cardLayout);
    }
    public void setLayout(GridBagLayouts gridBagLayouts)
    {
        window.setLayout(gridBagLayouts.gridBagLayout);
    }
    public void setLayout(GridLayouts gridLayouts)
    {
        window.setLayout(gridLayouts.gridLayout);
    }
    public void setLayout(SpringLayouts springLayouts)
    {
        window.setLayout(springLayouts.springLayout);
    }
}