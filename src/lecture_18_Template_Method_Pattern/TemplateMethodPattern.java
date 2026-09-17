package lecture_18_Template_Method_Pattern;

// Definition:
// Template method pattern design the skeleton of an algorithm for an operating deferring some steps to subclasses.
// Template method let subclasses redefine certain steps of an algorithm without changing the algorithm structure.


// =========== 1. Base class defining the template method ============
abstract class ModelTrainer {

    // The template method - final so subclasses can't change the sequence
    public final void trainPipeline(String dataPath) {
        loadData(dataPath);
        preprocessData();
        trainModel();
        evaluateModel();
        saveModel();
    }

    protected void loadData(String dataPath) {
        System.out.println("[Common]-Loading data from " + dataPath);
        // e.g. read csv, images etc.
    }

    protected void preprocessData() {
        System.out.println("[Common]-Preprocessing data");
    }

    protected abstract void trainModel();
    protected abstract void evaluateModel();

    // Provide a default save, but subclasses can override if needed
    protected void saveModel() {
        System.out.println("[Common]-Saving model to disk as default format");
    }
}


// ========== 2. Concrete subclass: Neural Network ============
class NeuralNetworkTrainer extends ModelTrainer {

    @Override
    protected void trainModel() {
        System.out.println("[NeuralNetwork]-Training Neural Network for 100 epochs");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[NeuralNetwork]-Evaluating accuracy and loss on validation set");
    }

    @Override
    protected void saveModel() {
        System.out.println("[NeuralNetwork]-Serializing network weights to file");
    }
}


// =========== 3. Concrete subclass: Decision Tree ============
class DecisionTreeTrainer extends ModelTrainer {

    // Use the default preprocessData() (train/test split + normalize)

    @Override
    protected void trainModel() {
        System.out.println("[DecisionTree]-Building decision tree with max_depth=5");
    }

    @Override
    protected void evaluateModel() {
        System.out.println("[DecisionTree]-Computing classification report (precision/recall)");
    }

    // use the default saveModel
}


public class TemplateMethodPattern {
    static void main() {

        System.out.println("\n======== Neural Network Training ========");
        ModelTrainer neuralNetworkTrainer = new NeuralNetworkTrainer();
        neuralNetworkTrainer.trainPipeline("data/images/");

        System.out.println("\n======== Decision Tree Training ========");
        ModelTrainer decisionTreeTrainer = new DecisionTreeTrainer();
        decisionTreeTrainer.trainPipeline("data/iris.csv");
    }
}
