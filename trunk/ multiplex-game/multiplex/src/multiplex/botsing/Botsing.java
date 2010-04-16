package multiplex.botsing;

import java.awt.Component;
import java.awt.Rectangle;

/*******************************************************************************************
 * 
 * <p>De klasse Botsing is een bibliotheek met statische methoden om te controleren of twee Componenten 
 * elkaar raken of overlappen.</p>
 * 
 * <p>Deze klasse is gemaakt ter ondersteuning bij het project "Realisatie van Software" 
 * van de opleiding Informatica aan de hogeschool Leiden</p>
 * 
 * <p>Voorbeeld van gebruik:</p> //test
 * 
 * <code>if (<strong>Botsing.overlapt( pacman, spookje )</strong> )</code>
 * <code>     // doe iets...</code>
 *      
 * <p><strong>Let op</strong>: je hoeft g��n instantie van de klasse Botsing te maken en je roept de methode aan via de naam van de klasse</p>
 * 
 * @author  Nelleke Louwe Kooijmans
 * @version maart 2009
 * 
 */
public class Botsing
{
  /*****************************************************************************************
   * 
   * @param een   een Component ( b.v. een JPanel )
   * @param twee  een andere Component ( b.v. een JPanel )
   * @return      een boolean die aangeeft of de twee componenten elkaar aan ��n van de zijden raken
   */
  public static boolean raakt( Component een, Component twee )
  {
    Rectangle r2 = new Rectangle( twee.getX()-1, twee.getY()-1, twee.getWidth()+2, twee.getHeight()+2 );
    Rectangle doorsnede = doorsnede( een, r2 );
    return ( !doorsnede.isEmpty() && (( doorsnede.width == 1 ) || (doorsnede.height == 1 )));
  }

  /*****************************************************************************************
   * 
   * @param een   een Component ( b.v. een JPanel )
   * @param twee  een andere Component ( b.v. een JPanel )
   * @return      een boolean die aangeeft of de twee componenten elkaar overlappen
   */
  public static boolean overlapt( Component een, Component twee )
  {
    Rectangle doorsnede = doorsnede( een, twee );
    return !doorsnede.isEmpty();
  }
  
  /*****************************************************************************************
   * 
   * @param een   een Component ( b.v. een JPanel )
   * @param twee  een andere Component ( b.v. een JPanel )
   * @return      een boolean die aangeeft of component twee geheel wordt overlapt door component ��n
   */
  public static boolean bevat( Component een, Component twee )
  {
    Rectangle doorsnede = doorsnede( een, twee );
    Rectangle r2 = new Rectangle( twee.getX(), twee.getY(), twee.getWidth(), twee.getHeight() );
    
    return doorsnede.equals( r2 );
  }

  /*****************************************************************************************
   * 
   * @param een   een Component ( b.v. een JPanel )
   * @param twee  een andere Component ( b.v. een JPanel )
   * @return      een int die aangeeft hoeveel pixels de twee componenten elkaar overlappen
   */
  public static int pixelsOverlap( Component een, Component twee )
  {
    Rectangle doorsnede = doorsnede( een, twee );
    return doorsnede.width * doorsnede.height;
  }
  
  /*****************************************************************************************
   * 
   * @param een   een Component ( b.v. een JPanel )
   * @param twee  een andere Component ( b.v. een JPanel )
   * @return      een int die aangeeft hoeveel procent van component ��n wordt overlapt door component twee
   */
  public static int procentOverlap( Component een, Component twee )
  {
    return pixelsOverlap( een, twee ) / ( een.getWidth() * een.getHeight() );
  }
  
  // hulpmethode om de doorsnede van twee componenten te berekenen
  private static Rectangle doorsnede( Component een, Component twee )
  {
    Rectangle r1 = new Rectangle( een.getX(), een.getY(), een.getWidth(), een.getHeight() );
    Rectangle r2 = new Rectangle( twee.getX(), twee.getY(), twee.getWidth(), twee.getHeight() );
    
    return r1.intersection( r2 );
  }

  // hulpmethode om de doorsnede van twee component en een rectangle te berekenen
  private static Rectangle doorsnede( Component een, Rectangle r2 )
  {
    Rectangle r1 = new Rectangle( een.getX(), een.getY(), een.getWidth(), een.getHeight() );
    return r1.intersection( r2 );
  }
}
