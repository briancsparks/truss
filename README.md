
# Truss

Key / Value logging, for easier machine-understanding of your code's behavior.

You already log your program's debug info. Use Truss to make your
logs be in an easy-to-parse and query format.

```Kotlin
tr.logd()
  .log("foo", foo)
  .log("ip", address)
  .end()
```
