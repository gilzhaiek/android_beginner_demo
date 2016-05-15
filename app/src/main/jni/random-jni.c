#include <jni.h>

#include <stdlib.h>     /* srand, rand */


JNIEXPORT jint JNICALL
Java_tech_eightman_beginnerdemo_IRandomServiceImpl_getRandomIntNative(JNIEnv *env, jobject instance,
                                                                      jint from, jint to) {
    if(to < from) {
        return from;
    }

    return rand() % (to - from + 1) + from;
}