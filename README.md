# gson_bug_example
Bug for https://github.com/google/gson/issues/1457

How to reproduce:

1. Checkout https://github.com/stsypanov/gson_bug_example
2. Run `GsonTest` (test is green)
3. Switch JDK to 11 (jdk-11.0.1)
4. Run `GsonTest` (test is red)

I think the reason here is usage of Unsafe in `UnsafeAllocator`
