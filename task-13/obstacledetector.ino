int trigger_pin = 2;
int echo_pin = 3;
int motor_pin = 10; 
int time;
int distance; 
void setup() 
{
        Serial.begin (9600); 
        pinMode (trigger_pin, OUTPUT); 
        pinMode (echo_pin, INPUT);
        pinMode (motor_pin, OUTPUT);
}
void loop() 
{
    digitalWrite (trigger_pin, HIGH);
    delayMicroseconds(10);
    digitalWrite (trigger_pin, LOW);
    time = pulseIn (echo_pin, HIGH);
    distance = (time * 0.034) / 2;

  if (distance >= 100) 
        {
        Serial.println (" motor rotating ");
        Serial.print (" Distance= ");              
        Serial.println (distance);        
        digitalWrite (motor_pin, HIGH);
        delay (500);
        }
  else {
        Serial.println (" motor stopped ");
        Serial.print (" Distance= ");              
        Serial.println (distance);        
        digitalWrite (motor_pin, LOW);
        delay (500);        
       } 
}
