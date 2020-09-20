import org.tensorflow.*;

public class HelloTf {
    public static void main(String[] args) throws Exception {
        try (Graph g = new Graph(); Session s = new Session(g)) {
            // 使用占位符构造一个图,添加两个浮点型的张量
            Output x = g.opBuilder("Placeholder", "x").setAttr("dtype", DataType.FLOAT).build().output(0);//创建一个OP
            Output y = g.opBuilder("Placeholder", "y").setAttr("dtype", DataType.FLOAT).build().output(0);
            Output z = g.opBuilder("Add", "z").addInput(x).addInput(y).build().output(0);
            System.out.println( " z= " + z);
            // 多次执行，每次使用不同的x和y值
            float[] X = new float[] { 1, 2, 3 };
            float[] Y = new float[] { 4, 5, 6 };
            for (int i = 0; i < X.length; i++) {
                try (Tensor tx = Tensor.create(X[i]);
                     Tensor ty = Tensor.create(Y[i]);
                     Tensor tz = s.runner().feed("x", tx).feed("y", ty).fetch("z").run().get(0)) {
                    System.out.println(X[i] + " + " + Y[i] + " = " + tz.floatValue());
                }
            }
        }

        Graph graph = new Graph();
        Tensor tensor = Tensor.create(2);
        Tensor tensor2 = tensor.create(3);
        Output output = graph.opBuilder("Const", "mx").setAttr("dtype", tensor.dataType()).setAttr("value", tensor).build().output(0);
        Output output2 = graph.opBuilder("Const", "my").setAttr("dtype", tensor2.dataType()).setAttr("value", tensor2).build().output(0);
        Output output3 =graph.opBuilder("Sub", "mz").addInput(output).addInput(output2).build().output(0);
        Session session = new Session(graph);
        Tensor ttt=  session.runner().fetch("mz").run().get(0);
        System.out.println(ttt.intValue());
        Tensor t= session.runner().feed("mx", tensor).feed("my", tensor2).fetch("mz").run().get(0);
        System.out.println(t.intValue());
        session.close();
        tensor.close();
        tensor2.close();
        graph.close();
    }

}
