package model;

/**
 * Classe representant les formes
 *
 * @author Oner
 */
public class Forme {

    private TypeForme type;

    public Forme(TypeForme type) {
        // TODO Auto-generated constructor stub
        this.type = type;
    }

    public TypeForme getType() {
        return type;
    }

    public void setType(TypeForme type) {
        this.type = type;
    }
    
    public String toString(){
        if(this.type == TypeForme.croix){
            return "X";
        }
        else{
            return "O";
        }
    }
}
