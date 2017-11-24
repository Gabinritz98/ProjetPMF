
#include "DHT.h"   // Librairie des capteurs DHT
#include <math.h>
 
#define DHTPIN 2    // Changer le pin sur lequel est branché le DHT

#define DHTTYPE DHT22      // DHT 22  (AM2302)
 
DHT dht(DHTPIN, DHTTYPE); 

void setup() {
  Serial.begin(9600);
  pinMode(4, OUTPUT);
  dht.begin();
}
 int iC = 0;
void loop() {
  // Délai de 1 seconde entre chaque mesure. La lecture prend 250 millisecondes
  delay(2000);

  String ans = SerialReadln();

  Serial.print("Recieved : ");
  Serial.println(ans);
  String iCs = getValue(ans, 'C', 1);
  iCs = getValue(iCs, 'd', 0);
  
  char ch[10];
  iCs.toCharArray(ch, 9);
  int iCt = atoi(ch);
  if(iCt != 0){
    iC = iCt;
  }
  int ETemp = analogRead(A0);
  float voltage = ((float)ETemp/1024)*5;
  float resist = -(10000*voltage)/(voltage-5);
  Serial.print("Resistance : ");
  Serial.println(resist);
  float extTemp = getTemp(resist);
  // Lecture du taux d'humidité
  float h = dht.readHumidity();
  // Lecture de la température en Celcius
  float t = dht.readTemperature();

  // Stop le programme
  if (isnan(h) || isnan(t)) {
    return;
  }
  int iE = extTemp*10;
  int iH = h*10;
  int iT = t*10;
  float c = iC/10;

  if(iT<=iC){
    digitalWrite(4, LOW);
  } else {
    digitalWrite(4, HIGH);
  }
  
  Serial.print("JAVA:H"); 
  Serial.print(iH);
  Serial.print("dI");
  Serial.print(iT);
  Serial.print("dC");
  Serial.print(iC);
  Serial.print("dE");
  Serial.print(iE);
  Serial.println(":EAVA");
}

String SerialReadln() {
  String ret = "";
  char curr;
  if(Serial.available()){
    while(curr=(char)Serial.read()){
      ret+=curr;
      if(curr==(char)10){
        break;
      }
    }
  }
  return ret;
}
String getValue(String data, char separator, int index)
{
    int found = 0;
    int strIndex[] = { 0, -1 };
    int maxIndex = data.length() - 1;

    for (int i = 0; i <= maxIndex && found <= index; i++) {
        if (data.charAt(i) == separator || i == maxIndex) {
            found++;
            strIndex[0] = strIndex[1] + 1;
            strIndex[1] = (i == maxIndex) ? i+1 : i;
        }
    }
    return found > index ? data.substring(strIndex[0], strIndex[1]) : "";
}
float getTemp(float resistance){
  float l1 = log(resistance);
  float l3 = pow(l1, 3);
  float a = 0.00109613;
  float b = 0.00024016;
  float c = 5.8743/pow(10, 8);
  float tK = 1/(a+b*l1+c*l3);
  float tC = tK-273.15;
  return tC;
}

