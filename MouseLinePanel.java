import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Write a description of class MouseLinePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MouseLinePanel extends JPanel implements MouseListener, MouseMotionListener
{
    // instance variables - replace the example below with your own
    private int width, height;

    private Vector<Point> listOfPositions;

    /**
     * Constructor for objects of class MouseLinePanel
     */
    public MouseLinePanel()
    {
        super();
        setPreferredSize(new Dimension(500, 500));
        width = getPreferredSize().width;
        height = getPreferredSize().height;
        setBackground( Color.BLACK );

        listOfPositions = new Vector<>();

        addMouseListener( this );
        addMouseMotionListener( this );
    }

    @Override
    public void mouseEntered( MouseEvent e ) { }

    @Override
    public void mouseExited( MouseEvent e ) { }

    @Override
    public void mouseClicked( MouseEvent e ) { }

    @Override
    public void mousePressed( MouseEvent e ) { }

    @Override
    public void mouseReleased( MouseEvent e ) { }

    @Override
    public void mouseMoved( MouseEvent e ) {

        if ( listOfPositions.size() >= 100 ) {
            // delete the first element in the list
            listOfPositions.removeElementAt( 0 );
        }

        // add the new position to the end of the list
        listOfPositions.addElement( new Point( e.getX(), e.getY() ) );

        repaint();
        e.consume();
    }

    @Override
    public void mouseDragged( MouseEvent e ) { }

    @Override
    public void paintComponent( Graphics g ) {
        super.paintComponent(g);
        g.setColor( Color.white );
        for ( int j = 1; j < listOfPositions.size(); ++j ) {
            Point A = (Point)(listOfPositions.elementAt(j-1));
            Point B = (Point)(listOfPositions.elementAt(j));
            g.drawLine( A.x, A.y, B.x, B.y );
        }
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("DrawingHouse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        MouseLinePanel panel = new MouseLinePanel();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
