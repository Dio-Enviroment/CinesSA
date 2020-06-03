package vista;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

public class Test extends JFrame implements HyperlinkListener {
  private JButton backButton = new JButton("<"), forwardButton = new JButton(">");

  private JTextField locationTextField = new JTextField(35);

  private JEditorPane displayEditorPane = new JEditorPane();

  private ArrayList pageList = new ArrayList();

  public Test() {
    setSize(640, 480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel buttonPanel = new JPanel();
    backButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        actionBack();
      }
    });
    backButton.setEnabled(false);
    buttonPanel.add(backButton);
    forwardButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        actionForward();
      }
    });
    forwardButton.setEnabled(false);
    buttonPanel.add(forwardButton);
    locationTextField.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          actionGo();
        }
      }
    });
    buttonPanel.add(locationTextField);
    JButton goButton = new JButton("GO");
    goButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        actionGo();
      }
    });
    buttonPanel.add(goButton);
    displayEditorPane.setContentType("text/html");
    displayEditorPane.setEditable(false);
    displayEditorPane.addHyperlinkListener(this);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(buttonPanel, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(displayEditorPane), BorderLayout.CENTER);
  }

  private void actionBack() {
    URL currentUrl = displayEditorPane.getPage();
    int pageIndex = pageList.indexOf(currentUrl.toString());
    try {
      showPage(new URL((String) pageList.get(pageIndex - 1)), false);
    } catch (Exception e) {
    }
  }

  private void actionForward() {
    URL currentUrl = displayEditorPane.getPage();
    int pageIndex = pageList.indexOf(currentUrl.toString());
    try {
      showPage(new URL((String) pageList.get(pageIndex + 1)), false);
    } catch (Exception e) {
    }
  }

  private void actionGo() {
    URL verifiedUrl = verifyUrl(locationTextField.getText());
    if (verifiedUrl != null) {
      showPage(verifiedUrl, true);
    } else {
      System.out.println("Invalid URL");
    }
  }

  private URL verifyUrl(String url) {
    if (!url.toLowerCase().startsWith("http://"))
      return null;

    URL verifiedUrl = null;
    try {
      verifiedUrl = new URL(url);
    } catch (Exception e) {
      return null;
    }

    return verifiedUrl;
  }

  private void showPage(URL pageUrl, boolean addToList) {
    try {
      URL currentUrl = displayEditorPane.getPage();
      displayEditorPane.setPage(pageUrl);
      URL newUrl = displayEditorPane.getPage();
      if (addToList) {
        int listSize = pageList.size();
        if (listSize <= 0) {
          return;
        }
        int pageIndex = pageList.indexOf(currentUrl.toString());
        if (pageIndex >= listSize - 1) {
          return;
        }
        for (int i = listSize - 1; i > pageIndex; i--) {
          pageList.remove(i);
        }
        pageList.add(newUrl.toString());
      }
      locationTextField.setText(newUrl.toString());
      updateButtons();
    } catch (Exception e) {
      System.out.println("Unable to load page");
    }
  }

  private void updateButtons() {
    if (pageList.size() < 2) {
      backButton.setEnabled(false);
      forwardButton.setEnabled(false);
    } else {
      URL currentUrl = displayEditorPane.getPage();
      int pageIndex = pageList.indexOf(currentUrl.toString());
      backButton.setEnabled(pageIndex > 0);
      forwardButton.setEnabled(pageIndex < (pageList.size() - 1));
    }
  }

  public void hyperlinkUpdate(HyperlinkEvent event) {
    HyperlinkEvent.EventType eventType = event.getEventType();
    if (eventType == HyperlinkEvent.EventType.ACTIVATED) {
      if (event instanceof HTMLFrameHyperlinkEvent) {
        HTMLFrameHyperlinkEvent linkEvent = (HTMLFrameHyperlinkEvent) event;
        HTMLDocument document = (HTMLDocument) displayEditorPane.getDocument();
        document.processHTMLFrameHyperlinkEvent(linkEvent);
      } else {
        showPage(event.getURL(), true);
      }
    }
  }

  public static void main(String[] args) {
    Test browser = new Test();
    browser.setVisible(true);
  }
}