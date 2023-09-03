# TradingApp
An application which executes different algorithms per signal

### Running the application
Choose `TradingApplication` as your main class and run

### End points
To give a signal to execute corresponding algorithm, hit the following end point

example is given
```
POST: http://localhost:8080/api/signals/handle
{ 
    "signal": 3 
}
```

