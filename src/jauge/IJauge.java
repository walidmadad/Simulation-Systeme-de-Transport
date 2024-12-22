package src.jauge;

public interface IJauge {
    boolean estRouge();  // Indique si la jauge est en rouge
    boolean estVert();   // Indique si la jauge est en vert
    boolean estBleu();   // Indique si la jauge est en bleu
    void incrementer();  // Incrémente la valeur de la jauge
    void decrementer();  // Décrémente la valeur de la jauge
}
