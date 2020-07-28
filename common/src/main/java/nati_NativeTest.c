#include "nati_NativeTest.h"
#include <stdio.h>
JNIEXPORT jint JNICALL Java_nati_NativeTest_t1(JNIEnv * arg1, jobject arg2){
  printf("hello native!");
  return 12345;
  }