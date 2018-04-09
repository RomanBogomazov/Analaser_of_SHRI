package Views.SHRIModul;

import Controllers.DAO.IDAO;
import Views.Filter;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import java.util.ArrayList;

/**
 * Created by User on 08.05.2017.
 */
public class Dots implements GLEventListener {
  private ArrayList<Float> xList = new ArrayList<>();
  private ArrayList<Float> yList = new ArrayList<>();
  private ArrayList<Float> xFWHMList = new ArrayList<>();
  private ArrayList<Float> yFWHMList = new ArrayList<>();
  private ArrayList<Float> gaussLevel = new ArrayList<>();
  private ArrayList<Float> bgLevel = new ArrayList<>();
  private ArrayList<Float> chiSquare = new ArrayList<>();
  private ArrayList<Float> mlLambda = new ArrayList<>();
  private ArrayList<ArrayList<String>> list;

  private float maxX = 0;
  private float maxY = 0;
  private IDAO idao;
  private Filter filter;

  Dots(Filter filter){
    this.filter = filter;
    //idao = new SQLDAO();
  }

  @Override
  public void init(GLAutoDrawable glAutoDrawable) {
/*    list = idao.select(new String[]{"Key", "X centr", "Y centr", "X FWHM", "Y FWHM", "Gauss level", "Background level",
        "Chi square", "Measurement key"}, "Particle", "Where `Gauss level`>=0");
*/
    for (int i=0; i<list.size(); i++){
      if (maxX<Float.valueOf(list.get(i).get(1))){
        maxX = Float.valueOf(list.get(i).get(1));
      }
      if (maxY<Float.valueOf(list.get(i).get(2))){
        maxY = Float.valueOf(list.get(i).get(2));
      }

      xList.add(Float.valueOf(list.get(i).get(1)));
      yList.add(Float.valueOf(list.get(i).get(2)));
      xFWHMList.add(Float.valueOf(list.get(i).get(3)));
      yFWHMList.add(Float.valueOf(list.get(i).get(4)));
      gaussLevel.add(Float.valueOf(list.get(i).get(5)));
      bgLevel.add(Float.valueOf(list.get(i).get(6)));
      chiSquare.add(Float.valueOf(list.get(i).get(7)));
      mlLambda.add(Float.valueOf(list.get(i).get(8)));
    }
  }

  @Override
  public void dispose(GLAutoDrawable glAutoDrawable) {

  }

  @Override
  public void display(GLAutoDrawable glAutoDrawable) {
    final GL2 gl = glAutoDrawable.getGL().getGL2();

    gl.glBegin (GL2.GL_POINTS);
    for (int i=0; i<xList.size(); i++){
      gl.glColor3f((float) Math.random(), (float) Math.random(), (float) Math.random());
      if(filter.isChecked(4)){
        if (filter.getMinValue(4)<gaussLevel.get(i) & gaussLevel.get(i)<filter.getMaxValue(4)) {
          gl.glVertex2f(2*xList.get(i)/maxX - 1f, 2*yList.get(i)/maxY - 1f);
        }
        else{
          gl.glColor3f(0f, 0f, 0f);
          gl.glVertex2f(2*xList.get(i)/maxX - 1f, 2*yList.get(i)/maxY - 1f);
        }
      }
      else {
        gl.glVertex2f(2*xList.get(i)/maxX - 1f, 2*yList.get(i)/maxY - 1f);
      }
    }
    gl.glEnd();
    gl.glFlush();
  }

  @Override
  public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

  }
}