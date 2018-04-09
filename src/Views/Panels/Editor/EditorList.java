package Views.Panels.Editor;

/**
 * Created by User on 30.09.2017.
 */
public class EditorList {
    private Editor prev;
    private int value;
    private Editor next;

    public EditorList(Editor[] editors) {
        int counter = 0;
        for (Editor editor : editors) {
            value = counter;
            add(editor);
            counter++;
        }
    }

    private void add(Editor editor){
        if (prev==null){
            prev=editor;
        } else{
            next=editor;
            next.add(editor);
        }
    }

    public void printValue(){
        System.out.println(value);
    }
}