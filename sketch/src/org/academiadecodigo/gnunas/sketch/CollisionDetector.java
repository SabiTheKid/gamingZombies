package org.academiadecodigo.gnunas.sketch;

import org.academiadecodigo.gnunas.sketch.GameObject.GameObject;

public class CollisionDetector {

    //Implements the logic for analysing the collisions between objects( Player and Walls)

    // Have an array with all the gameObjects
     private GameObject[] objectsGame;

     public CollisionDetector(GameObject[] objectsGame){
         this.objectsGame = objectsGame;
     }

<<<<<<< HEAD
<<<<<<< HEAD


=======
=======
>>>>>>> master
     public void checkCollision( GameObject object){

         for ( GameObject obj : objectsGame){

             if ( obj == object){
                 continue;
             }

             if (obj.getPos().equals(object.getPos())){
                 obj.collided(object);
             }
         }
     }
<<<<<<< HEAD
>>>>>>> 860c2ea86bf1126d45525bca8d35eb3d39850409
=======
>>>>>>> master
}
