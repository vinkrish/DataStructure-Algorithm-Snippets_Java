### Edwards-Curve Digital Signature Algorithm 

Support for the Edwards-Curve Digital Signature Algorithm (EdDSA) is added in Java 15 for better cryptographic performance and security.

```java
KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
KeyPair kp = kpg.generateKeyPair();

Signature sig = Signature.getInstance("Ed25519");
sig.initSign(kp.getPrivate());
sig.update("test message".getBytes());
byte[] signature = sig.sign();

sig.initVerify(kp.getPublic());
sig.update("test message".getBytes());
System.out.println(sig.verify(signature)); // Output: true
```