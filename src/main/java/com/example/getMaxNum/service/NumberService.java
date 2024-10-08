package com.example.getMaxNum.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class NumberService {

    private List<Integer> integerList;

    public int getMaxNumber(String path, int nNum) {
        integerList = readExcelFile(path);
        recQuickSort(0, integerList.size() - 1);
        return integerList.get(integerList.size() - nNum);
    }

    private void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = integerList.get(right);
            int partition = partition(left, right, pivot);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }

    private int partition(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (integerList.get(++leftPtr) < pivot) ;
            while (rightPtr > 0 && integerList.get(--rightPtr) > pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        int temp;
        temp = integerList.get(index1);
        integerList.set(index1, integerList.get(index2));
        integerList.set(index2, temp);
    }

    private List<Integer> readExcelFile(String path) {
        List<Integer> numbers = new ArrayList<>();
        try (Workbook workbook = WorkbookFactory.create(new File(path))) {
            for (Row row : workbook.getSheetAt(0)) {
                for (Cell cell : row) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
}
