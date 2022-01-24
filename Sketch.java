import processing.core.PApplet;


public class Sketch extends PApplet {
  float[] SnowflakeY = new float[50];
  float[] SnowflakeX = new float[50];
  float[] Snowflake2Y = new float[50];
  float[] Snowflake2X = new float[50];
  float[] lengthofscreen = new float[width];
  boolean keyup = false;
  boolean keydown = false;
  int snowground = 600;

  int num = 25;
  int indexPosition = 24;
  int[] x = new int[num];
  int[] y = new int[num];
  float holder = 0;
  float holder2 = 0;
  float place;
  float place2;

  //int[] counter = new int[24];
  double[] counter = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

  int num2 = 25;

  public void settings() {
    // put your size call here
    size(600, 600);

  }


  public void setup() {
    for (int i = 0; i < SnowflakeY.length; i++) {
      SnowflakeY[i] = random(height);
    }
    for (int i = 0; i < SnowflakeX.length; i++) {
      SnowflakeX[i] = random(width);
    }
    for (int i = 0; i < SnowflakeY.length; i++) {
      Snowflake2Y[i] = random(height);
    }
    for (int i = 0; i < SnowflakeX.length; i++) {
      Snowflake2X[i] = random(width);
    }
  }

  public void draw() {

    int height25 = width/25;
    int[] pile = new int[height25];

    background(20);

    for (int i = 0; i < SnowflakeY.length; i++) {

      ellipse(SnowflakeX[i], SnowflakeY[i], 20, 20);
      ellipse(Snowflake2X[i], Snowflake2Y[i], 10, 10);
      //ellipse(SnowflakeX[i]+randomNum, SnowflakeY[i]+25, 10, 10);
      //ellipse(SnowflakeX[i]*randomNum, SnowflakeY[i]-25, 5, 5);

      //System.out.println(SnowflakeX[i]);
   

      if (keydown) {
        SnowflakeY[i] = SnowflakeY[i]  - (3/2);
      }
      if (keyup) {
        SnowflakeY[i] = SnowflakeY[i] + 3;
      }

      SnowflakeY[i] = SnowflakeY[i] + 2;
      Snowflake2Y[i] = Snowflake2Y[i] + 2;

      if (SnowflakeY[i] > height) {

        SnowflakeY[i] = 0;
        Snowflake2Y[i] = 0;
      }


      if (keydown) {
        SnowflakeY[i] = SnowflakeY[i]  - 1;
      }
      if (keyup) {
        SnowflakeY[i] = SnowflakeY[i] + 3;
      }
      SnowflakeY[i] = SnowflakeY[i] + 2;
      Snowflake2Y[i] = Snowflake2Y[i] + 2;

      if(SnowflakeY[i]>=580||Snowflake2Y[i]>=580){
        holder = SnowflakeX[i];
        holder2 = Snowflake2X[i];
        place = holder/25;
        place2 = holder2/25;
        counter[(int)place] = counter[(int)place] + 0.1;
        counter[(int)place2] = counter[(int)place2] + 0.1;
      }
    }

    for(int t = 23; t >= 0; t--){
      pile[t]=18+(2*((int)counter[t]));
      System.out.println(counter[t]);
    }

    for (int k = 0; k < pile.length; k++){
    rect(0+(25*k),height-pile[k],20,pile[k]);

     }


    x[indexPosition] = mouseX;
    y[indexPosition] = mouseY;
    // Cycle between 0 and the number of elements
    indexPosition = (indexPosition - 1);
    if(indexPosition == 0){
      indexPosition = indexPosition+23;
    }
    for (int i = 0; i < num; i++) {
      // Set the array position to read
      int pos = (indexPosition + i + 1) % (num);
      float radius = (num-i);
      noStroke();
      ellipse(x[pos], y[pos], radius, radius);
    }
        
}


  public void keyPressed() {
    if (keyCode == UP) {
      keyup = true;
    }
    if (keyCode == DOWN) {
      keydown = true;
    }
  }
  public void keyReleased() {
    if (keyCode == UP) {
      keyup = false;
    }
    if (keyCode == DOWN) {
      keydown = false;
    }
  }
}