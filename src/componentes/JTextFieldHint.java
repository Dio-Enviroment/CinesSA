package componentes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;


public class JTextFieldHint extends JTextField implements FocusListener {

    private static final long serialVersionUID = 1L;
    private final Font fontLost = new Font("Monaco", Font.ITALIC, 10);
    private final Font fontGained = new Font("Monaco", Font.PLAIN, 12);
    private final Color colorLost = Color.RED;
    private final Color colorGained = Color.BLACK;
    private String hint;


    public JTextFieldHint() {
        addFocusListener(this);
    }

    public void setHint(String hint) {
        setForeground(colorLost);
        setFont(fontLost);
        setText(hint);
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(getHint())) {
            setText("");
            setFont(fontGained);
            setForeground(colorGained);
        } else {
            setForeground(colorGained);
            setFont(fontGained);
            setText(getText());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().length() <= 0) {
            setHint(getHint());
        } else {
            setForeground(colorGained);
            setFont(fontGained);
            setText(getText());
        }
    }
}
