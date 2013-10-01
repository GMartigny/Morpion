/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion.v2;

/**
 *
 * @author Guigui
 */
class MorpionController {
    
    MorpionModel model;
    MorpionView view;

    public MorpionController() {
        this.model = new MorpionModel();
        this.view = new MorpionView("Morpion Game", model);
    }
    
}
