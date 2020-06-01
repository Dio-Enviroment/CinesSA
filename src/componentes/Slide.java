package componentes;

import java.io.File;

import javax.swing.JPanel;
import javax.swing.event.EventListenerList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Graphics;

public class Slide extends JPanel {

	private static final long serialVersionUID = 1L;
	private SlideItem[] slideItems;
	private int[] itemsPos;
	private SlideContainer slideContainer;
	private int width, pos;
	private boolean retorno = true;

	private Timer timer = new Timer();
	private TimerTask task;

	protected EventListenerList listenerList = new EventListenerList();

	public Slide(String[] paths, int width, int height) {
		this.width = width;
		slideItems = new SlideItem[paths.length];
		itemsPos = new int[paths.length];

		for (int i = 0; i < paths.length; i++) {
			slideItems[i] = new SlideItem(paths[i]);
			itemsPos[i] = i * width * -1;
		}

		slideContainer = new SlideContainer(slideItems, height, width);

		setLayout(null);

		slideContainer.setBounds(0, 0, width * paths.length, height);
		add(slideContainer);

	}

	private int location = 0;
	private int timeTransition = 2000, delayTransition = 2000;

	public void initTransition() {
		setPos(0);
		location = 0;
		task = null;
		task = new TimerTask() {
			@Override
			public void run() {
				int calFin = slideItems.length * width - width;
				int calPos = location % width;

				slideContainer.setLocation(location * -1, 0);

				if (retorno) {
					if (location < calFin) {
						location++;
					} else {
						retorno = false;
					}
				} else {
					if (location > 0) {
						location--;
					} else {
						retorno = true;
					}
				}

				if (calPos == 0) {
					if (retorno) {
						location++;
					} else {
						location--;
					}
					
					for (int i = 0; i < itemsPos.length; i++) {
						if (itemsPos[i] == slideContainer.getLocation().getX()) {
							setPos(i);
						}
					}
					fireChangePos(new ChangePos(this));
					try {
						Thread.currentThread();
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
				}

			}
		};
		timer.schedule(task, timeTransition / width, delayTransition / width);
	}

	public void endTransition() {
		task.cancel();
	}

	public void setPos(int pos) {
		this.pos = pos;
		slideContainer.setLocation(pos * width * -1, 0);
	}

	public int getPos() {
		return this.pos;
	}

	public void addChangePos(ChangePosListener listener) {
		listenerList.add(ChangePosListener.class, listener);
	}

	private void fireChangePos(ChangePos evt) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i = i + 2) {
			if (listeners[i] == ChangePosListener.class) {
				((ChangePosListener) listeners[i + 1]).ChangePosEvent(evt);
			}
		}
	}

	class SlideContainer extends JPanel {

		private static final long serialVersionUID = 1L;

		public SlideContainer(SlideItem[] slideItems, int height, int width) {
			setLayout(null);

			for (int i = 0; i < slideItems.length; i++) {
				slideItems[i].setBounds(width * i, 0, width, height);
				add(slideItems[i]);
			}
		}
	}

	class SlideItem extends JPanel {

		private static final long serialVersionUID = 1L;
		private BufferedImage img;

		public SlideItem(String path) {
			try {
				img = ImageIO.read(new File(path + ""));
			} catch (IOException ex) {
				System.out.println("No funciona la img");
			}
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}

	}
}
