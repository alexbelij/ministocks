/*
 The MIT License

 Copyright (c) 2013 Nitesh Patel http://niteshpatel.github.io/ministocks

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 */

package nitezh.ministock.tests;

import junit.framework.TestCase;
import nitezh.ministock.domain.PortfolioStock;
import nitezh.ministock.domain.PortfolioStockRepository;
import nitezh.ministock.tests.mocks.MockCache;
import nitezh.ministock.tests.mocks.MockStorage;
import nitezh.ministock.tests.mocks.MockWidgetRepository;


public class PortfolioStockRepositoryTests extends TestCase {

    private PortfolioStockRepository stockRepository;

    public void setUp() {
        this.stockRepository = new PortfolioStockRepository(
                new MockStorage(),
                new MockCache(),
                new MockWidgetRepository());
    }

    public void testCanRemoveTwoUnusedSymbols() {
        // Arrange
        this.stockRepository.portfolioStocksInfo.put(
                "test1", new PortfolioStock("test1", "", "", "", "", "", "", ""));

        this.stockRepository.portfolioStocksInfo.put(
                "test2", new PortfolioStock("test2", "", "", "", "", "", "", ""));

        // Act
        this.stockRepository.removeUnused();
    }
}