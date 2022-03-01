package tp.baignoire.exception;

public class VolumeInvalideException extends RuntimeException{
    @Override
    public String toString() {
        return "Le volume renseigné n'est pas valide. Il doit être compris entre 0 et le volume maximum de la baignoire.";
    }
}
