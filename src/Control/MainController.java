package Control;

import Model.BinaryTree;
import View.DrawingPanel;
import View.TreeView.TreeNode;
import View.TreeView.TreePath;

/**
 * Created by Jean-Pierre on 12.01.2017.
 */
public class MainController {

    private BinaryTree<String> binaryTree;

    public MainController(){
        binaryTree = new BinaryTree<>(""); // Ein Baum ohne Wurzel-Inhalt ist auf dauer ein leerer Baum - es lassen sich laut Dokumentation nichtmal Bäume anhängen. Also wird die Wurzel gefüllt.
        createMorseTree();
    }

    /**
     * Zur Präsentation des Programms wird der Morsecode im Baum dargestellt.
     */
    private void createMorseTree(){
        //TODO 02: Vervollständige den Morsebaum. Such bei google nach "morsecode as tree" als Vorlage. Das hilft, die Übersicht zu wahren.
        BinaryTree<String> left = new BinaryTree<>("E",
                new BinaryTree<>("I",
                        new BinaryTree<>("S",
                                new BinaryTree<>("H"),
                                new BinaryTree<>("V")),
                        new BinaryTree<>("U",
                                new BinaryTree<>("F"),
                                new BinaryTree<>(""))),
                new BinaryTree<>("A",
                        new BinaryTree<>("R",
                                new BinaryTree<>("L"),
                                new BinaryTree<>("")),
                        new BinaryTree<>("W",
                                new BinaryTree<>("P"),
                                new BinaryTree<>("J"))));
        BinaryTree<String> right = new BinaryTree<>("T",
                new BinaryTree<>("N",
                        new BinaryTree<>("D",
                                new BinaryTree<>("B"),
                                new BinaryTree<>("X")),
                        new BinaryTree<>("K",
                                new BinaryTree<>("C"),
                                new BinaryTree<>("Y"))),
                new BinaryTree<>("M",
                        new BinaryTree<>("G",
                                new BinaryTree<>("Z"),
                                new BinaryTree<>("Q")),
                        new BinaryTree<>("O",
                                new BinaryTree<>(""),
                                new BinaryTree<>(""))));



        binaryTree.setLeftTree(left);
        binaryTree.setRightTree(right);
    }

    /**
     * Der Baum wird im übergebenem Panel dargestellt.
     * Dazu wird zunächst die alte Zeichnung entfernt.
     * Im Anschluss wird eine eine internete Hilfsmethode aufgerufen.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     */
    public void showTree(DrawingPanel panel){
        panel.removeAllObjects();
        //Der Baum wird in der Mitte des Panels beginnend gezeichnet: x = panel.getWidth()/2
        //Der linke und rechte Knoten in Tiefe 1 sind jeweils ein Viertel der Breite des Panels entfernt: spaceToTheSide = panel.getWidth()/4
        showTree(binaryTree, panel, panel.getWidth()/2, 50, panel.getWidth()/4);

	//Aufruf fordert das Panel zur Aktualisierung auf.
	panel.repaint();
    }

    /**
     * Hilfsmethode zum Zeichnen des Baums.
     * Für jeden Knoten wird ein neues TreeNode-Objekt dem panel hinzugefügt.
     * Für jede Kante wird ein neues TreePath-Pbjekt dem panel hinzugefügt.
     * @param tree Der zu zeichnende (Teil)Binärbaum.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     * @param startX x-Koordinate seiner Wurzel
     * @param startY y-Koordinate seiner Wurzel
     * @param spaceToTheSide Gibt an, wie weit horizontal entfernt die folgenden Bäume gezeichnet werden soll.
     */
    private void showTree(BinaryTree tree, DrawingPanel panel, double startX, double startY, double spaceToTheSide) {
        //TODO 03: Vervollständige diese Methode. Aktuell wird nur der Wurzelknoten gezeichnet.
        /*if (!tree.isEmpty()) {
            TreeNode node = new TreeNode(startX, startY, 10, tree.getContent().toString(), false);
            TreeNode eNode = new TreeNode(startX - spaceToTheSide, startY + 50, 10, tree.getLeftTree().getContent().toString(), false);
                TreeNode iNode = new TreeNode(startX - spaceToTheSide*1.5, startY + 100, 10, tree.getLeftTree().getLeftTree().getContent().toString(), false);
                    TreeNode sNode = new TreeNode(startX - spaceToTheSide*1.66, startY + 150, 10, tree.getLeftTree().getLeftTree().getLeftTree().getContent().toString(), false);
                        TreeNode hNode = new TreeNode(startX - spaceToTheSide * 1.75, startY + 200, 10, tree.getLeftTree().getLeftTree().getLeftTree().getLeftTree().getContent().toString(), false);
                        TreeNode vNode = new TreeNode(startX - spaceToTheSide * 1.58, startY + 200, 10, tree.getLeftTree().getLeftTree().getLeftTree().getRightTree().getContent().toString(), false);
                    TreeNode uNode = new TreeNode(startX - spaceToTheSide*1.33, startY + 150, 10, tree.getLeftTree().getLeftTree().getRightTree().getContent().toString(), false);
                        TreeNode fNode = new TreeNode(startX - spaceToTheSide*1.41, startY +200, 10, tree.getLeftTree().getLeftTree().getRightTree().getLeftTree().getContent().toString(), false);
                        TreeNode nodeU = new TreeNode(startX - spaceToTheSide*1.25, startY + 200, 10, tree.getLeftTree().getLeftTree().getRightTree().getRightTree().getContent().toString(), false);
                TreeNode aNode = new TreeNode(startX - spaceToTheSide*0.5, startY + 100, 10, tree.getLeftTree().getRightTree().getContent().toString(), false);
                    TreeNode rNode = new TreeNode(startX - spaceToTheSide*0.66, startY + 150, 10, tree.getLeftTree().getRightTree().getLeftTree().getContent().toString(), false);
                        TreeNode lNode = new TreeNode(startX - spaceToTheSide*0.75, startY + 200, 10, tree.getLeftTree().getRightTree().getLeftTree().getLeftTree().getContent().toString(), false);
                        TreeNode nodeR = new TreeNode(startX - spaceToTheSide*0.58, startY + 200, 10, tree.getLeftTree().getRightTree().getLeftTree().getRightTree().getContent().toString(), false);
                    TreeNode wNode = new TreeNode(startX - spaceToTheSide*0.33, startY + 150, 10, tree.getLeftTree().getRightTree().getRightTree().getContent().toString(), false);
                        TreeNode pNode = new TreeNode(startX - spaceToTheSide*0.41, startY + 200, 10, tree.getLeftTree().getRightTree().getRightTree().getLeftTree().getContent().toString(), false);
                        TreeNode jNode = new TreeNode(startX - spaceToTheSide*0.25, startY + 200, 10, tree.getLeftTree().getRightTree().getRightTree().getRightTree().getContent().toString(), false);
            TreeNode tNode = new TreeNode(startX + spaceToTheSide, startY + 15, 10, tree.getRightTree().getContent().toString(), false);
                TreeNode nNode = new TreeNode(startX + spaceToTheSide*0.5, startY + 100, 10, tree.getRightTree().getLeftTree().getContent().toString(), false);
                    TreeNode dNode = new TreeNode(startX + spaceToTheSide*0.33, startY + 150, 10, tree.getRightTree().getLeftTree().getLeftTree().getContent().toString(), false);
                        TreeNode bNode = new TreeNode(startX + spaceToTheSide * 0.25, startY + 200, 10, tree.getRightTree().getLeftTree().getLeftTree().getLeftTree().getContent().toString(), false);
                        TreeNode xNode = new TreeNode(startX + spaceToTheSide * 0.41, startY + 200, 10, tree.getRightTree().getLeftTree().getLeftTree().getRightTree().getContent().toString(), false);
                    TreeNode kNode = new TreeNode(startX + spaceToTheSide*0.66, startY + 150, 10, tree.getRightTree().getLeftTree().getRightTree().getContent().toString(), false);
                        TreeNode cNode = new TreeNode(startX + spaceToTheSide*0.58, startY +200, 10, tree.getRightTree().getLeftTree().getRightTree().getLeftTree().getContent().toString(), false);
                        TreeNode yNode = new TreeNode(startX + spaceToTheSide*0.75, startY + 200, 10, tree.getRightTree().getLeftTree().getRightTree().getRightTree().getContent().toString(), false);
                TreeNode mNode = new TreeNode(startX + spaceToTheSide*1.5, startY + 100, 10, tree.getRightTree().getRightTree().getContent().toString(), false);
                    TreeNode gNode = new TreeNode(startX + spaceToTheSide*1.33, startY + 150, 10, tree.getRightTree().getRightTree().getLeftTree().getContent().toString(), false);
                        TreeNode zNode = new TreeNode(startX + spaceToTheSide*1.25, startY + 200, 10, tree.getRightTree().getRightTree().getLeftTree().getLeftTree().getContent().toString(), false);
                        TreeNode qNode = new TreeNode(startX + spaceToTheSide*1.41, startY + 200, 10, tree.getRightTree().getRightTree().getLeftTree().getRightTree().getContent().toString(), false);
                    TreeNode oNode = new TreeNode(startX + spaceToTheSide*1.66, startY + 150, 10, tree.getRightTree().getRightTree().getRightTree().getContent().toString(), false);
                        TreeNode nodeO1 = new TreeNode(startX + spaceToTheSide*1.58, startY + 200, 10, tree.getRightTree().getRightTree().getRightTree().getLeftTree().getContent().toString(), false);
                        TreeNode nodeO2 = new TreeNode(startX + spaceToTheSide*1.75, startY + 200, 10, tree.getRightTree().getRightTree().getRightTree().getRightTree().getContent().toString(), false);


            panel.addObject(node);
                panel.addObject(eNode);
                panel.addObject(iNode);
                    panel.addObject(sNode);
                        panel.addObject(hNode);
                        panel.addObject(vNode);
                    panel.addObject(uNode);
                        panel.addObject(fNode);
                        panel.addObject(nodeU);
                panel.addObject(aNode);
                    panel.addObject(rNode);
                        panel.addObject(lNode);
                        panel.addObject(nodeR);
                    panel.addObject(wNode);
                        panel.addObject(pNode);
                        panel.addObject(jNode);
                panel.addObject(tNode);
                    panel.addObject(nNode);
                        panel.addObject(dNode);
                            panel.addObject(bNode);
                            panel.addObject(xNode);
                        panel.addObject(kNode);
                            panel.addObject(cNode);
                            panel.addObject(yNode);
                    panel.addObject(mNode);
                        panel.addObject(gNode);
                            panel.addObject(zNode);
                            panel.addObject(qNode);
                        panel.addObject(oNode);
                            panel.addObject(nodeO1);
                            panel.addObject(nodeO2);
        }
		*/
        //TODO 03: Vervollständige diese Methode. Aktuell wird nur der Wurzelknoten gezeichnet.
        if (!tree.isEmpty()) {
            TreeNode node = new TreeNode(startX, startY, 10, tree.getContent().toString(), false);
            panel.addObject(node);
            if(tree.getLeftTree() != null){
                TreePath pathLeft = new TreePath(startX,startY+15,startX-spaceToTheSide/1.2,startY+40,2,false);
                panel.addObject(pathLeft);
                showTree(tree.getLeftTree(),panel,startX-spaceToTheSide/1.2,startY+60,spaceToTheSide/1.95);
            }
            if(tree.getRightTree() != null){
                TreePath pathRight = new TreePath(startX,startY+15,startX+spaceToTheSide/1.2,startY+40,2,false);
                panel.addObject(pathRight);
                showTree(tree.getRightTree(),panel,startX+spaceToTheSide/1.2,startY+60,spaceToTheSide/1.95);
            }
        }
    }

    /**
     * Es wird das Ergebnis einer Traversierung bestimmt.
     * Ruft dazu eine interne Hilfsmethode auf.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    public String traverse(){
        return traverse(binaryTree);
    }

    /**
     * Interne hilfsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    private String traverse(BinaryTree tree){
        //TODO 04: Nachdem wir geklärt haben, was eine Traversierung ist, muss diese Methode noch vervollständigt werden. Sollte ein Kinderspiel sein.
        String a = "";
        String b = "";
        String c;
        if (!tree.getLeftTree().isEmpty()){
            a = traverse(tree.getLeftTree()) + ", ";
        }
        if (!tree.getRightTree().isEmpty()){
            b = traverse(tree.getRightTree()) + ", ";
        }
        c = tree.getContent().toString();
        return a + b + c;
    }
	
    /**
     * Interne Übungsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Die Anzahl der Knoten in diesem Baum
     */
    private int countNodes(BinaryTree tree){
        //TODO 05: Übungsmethode
	return 0;
    }
}
