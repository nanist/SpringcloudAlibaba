package com.naixin.clickhouse.utils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.synonym.SynonymFilterFactory;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.util.FilesystemResourceLoader;
import org.apache.lucene.store.DataInput;
import org.apache.lucene.store.InputStreamDataInput;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.CharsRef;
import org.apache.lucene.util.IntsRef;
import org.apache.lucene.util.NumericUtils;
import org.apache.lucene.util.Version;
import org.apache.lucene.util.fst.*;

/**
 * @author lgn
 * @version 1.0
 * @date 2022/1/13 9:44
 */
public class FSTUtils {

    public static void main(String[] args) {
        try {
            String inputValues[] = {"cat", "deep", "do", "dog", "dogs"};
            long outputValues[] = {5, 7, 17, 18, 21};

            PositiveIntOutputs outputs = PositiveIntOutputs.getSingleton(true);

            Builder<Long> builder = new Builder<Long>(FST.INPUT_TYPE.BYTE1, outputs);
            BytesRef scratchBytes = new BytesRef();
            IntsRef scratchInts = new IntsRef();
            for (int i = 0; i < inputValues.length; i++) {
                scratchBytes.copyChars(inputValues[i]);
                builder.add(Util.toIntsRef(scratchBytes, scratchInts), outputValues[i]);
            }
            FST<Long> fst = builder.finish();
            Long value = Util.get(fst, new BytesRef("dog"));
            System.out.println(value); // 18
        } catch (Exception e) {
            ;
        }
    }
}
