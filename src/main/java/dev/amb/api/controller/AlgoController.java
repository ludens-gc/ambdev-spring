package dev.amb.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.amb.api.algorithms.AlgoData;
import dev.amb.api.algorithms.algorithm.CountInt;
import dev.amb.api.algorithms.algorithm.CumSum;
import dev.amb.api.algorithms.algorithm.Fibonacci;
import dev.amb.api.algorithms.algorithm.GCDCalculator;
import dev.amb.api.algorithms.algorithm.IsPrime;
import dev.amb.api.algorithms.algorithm.QuickSort;

@RestController
@RequestMapping("/algorithms")
public class AlgoController {
    private static class AlgoResponse {
        @JsonInclude(Include.NON_NULL)
        private String result;

        public AlgoResponse(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }

    @PostMapping
    public ResponseEntity<AlgoResponse> execAlgo(@RequestBody AlgoData jsonData) {
        String algorithm = jsonData.getAlgorithm();
        String value = jsonData.getValue();
        String result = "";

        switch (algorithm) {
            case "countint":
                result = CountInt.exec(value);
                break;
            case "cumsum":
                result = CumSum.exec(value);
                break;
            case "fibonacci":
                result = Fibonacci.exec(value);
                break;
            case "gcd":
                result = GCDCalculator.exec(value);
                break;
            case "isprime":
                result = IsPrime.exec(value);
                break;
            case "quicksort":
                result = QuickSort.exec(value);
                break;
            default:
                break;
        }

        AlgoResponse response = new AlgoResponse(result);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
