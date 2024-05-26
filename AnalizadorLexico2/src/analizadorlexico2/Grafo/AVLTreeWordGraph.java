/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2.Grafo;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import javax.swing.JFrame;

public class AVLTreeWordGraph extends JFrame {
    private AVLNodeWord root;
    private mxGraph graph;
    private Object parent;

    public AVLTreeWordGraph(AVLNodeWord root) {
        this.root = root;
        this.graph = new mxGraph();
        this.parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        try {
            // Recursively add nodes to graph
            addNodeToGraph(root);
            // Apply layout to graph
            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.execute(graph.getDefaultParent());
        } finally {
            graph.getModel().endUpdate();
        }
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        pack();
        setVisible(true);
    }

    private Object addNodeToGraph(AVLNodeWord node) {
        Object v = graph.insertVertex(parent, null, node.getWord(), 0, 0, 50, 30);
        if (node.getLeft() != null) {
            Object left = addNodeToGraph(node.getLeft());
            graph.insertEdge(parent, null, "", v, left);
        }
        if (node.getRight() != null) {
            Object right = addNodeToGraph(node.getRight());
            graph.insertEdge(parent, null, "", v, right);
        }
        return v;
    }
}
