# TradingApp
An application which executes different algorithms per signal

### Building application
Prerequisites
- Jdk Version 17
- Maven

To build go to root of repo and execute
```
mvn clean package
```
You should be seeing `trading-0.0.1-SNAPSHOT.jar` inside `/target` folder inside your repo.

### Running the application
Go to `/target` folder in root of the repo.
and execute the command
```
java -jar trading-0.0.1-SNAPSHOT.jar
```
Wait for the server to star up.

### End points
To give a signal to execute corresponding algorithm, hit the following end point

example is given
```
POST: http://localhost:8080/api/signals/handle
{ 
    "signal": 3 
}
```
The log is written to console now.


### The approach
- Every combination of `Algo` methods, we call it as a `Strategy`.
- The approach takes implementation of `SignalStrategy` and each implementation executes `Algo` with its combinations of methods.
- Which signal corresponds to which implementation of `SignalStrategy`, is defined in a configuration file which is located in `src/main/resources/strategies.json`.
- The above approach helps developers to implement very big number of Strategies.
- Each strategy is not created as spring-managed-bean, which reduces the complexity of maintaining this beans.
- The signal to implementation mapping can be changed with change in `strategies.json`, so that we don't need to touch the java classes.
- Each implementation is simple plain java class and so it helps to easily manage and test.
- If needed, the strategies can be externalised (and packaged to this classpath on build), which makes it easy to maintain Strategies.  
- In this approach, if it is needed, we can load the config file from a Database, which helps easier manipulation of signal to Strategy mapping (Have a separate implementation of `StrategyLoader` instead of `StrategyFileLoader`).
- Only the Strategies which are defined in file `strategies.json` is initialized, and so this is a dynamic initialisation (If it was spring-bean, spring has to maintain all strategy implementations )
- `SignalStrategy1.java`, `SignalStrategy2.java` etc. are implemented as it is already given.
- `SignalStrategy500.java` is a random implementation for demonstration. It is not configured in `strategies.json` (To show that we can configure implementations without touching java classes)


#### The alternative approach (Which is not implemented)
- An alternative approach would be like using a Rule engine like Drools.
- Need to add package `org.kie.kie-api` to project, and then configure rules for signal to strategy mapping.
- A typical example of rule would look something like
```
rule "Signal 1 Strategy"
when
    SignalRequest(signal == 1)
then
    Algo algo = new Algo();
    algo.setUp();
    algo.setAlgoParam(1, 60);
    algo.performCalc();
    algo.submitToMarket();
    algo.doAlgo();
end
```
- We need to access `KieSession` and fire rules.

#### The git flow
- The main branch is called `main`.
- The branch `develop` keeps on growing.
- Each feature is created from `develop` branch and named `feature/JIRA-<no>`
- Once the feature is completed, it is merged to `develop`.
- Once all the features are completed, creates a `realease/<version>` branch.
- Regression bugs are fixed to `realease/<version>` and to `develop` separately.
- Once all regression bugs are fixed, merge `release/<version>` to `main`.
- Every merge to `main` goes to production.
