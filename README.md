# wgsl-antlr-grammar

The grammar is located at [./src/main/antlr/WGSL.g4](./src/main/antlr/WGSL.g4).

## Testing

```sh
$ ./gradlew run -q --args="tests/<test_case>.wgsl" | diff "tests/<test_case>.expected" -
```
