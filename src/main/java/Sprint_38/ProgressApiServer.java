package Sprint_38;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Simple embedded HTTP server that exposes a sample API and a small web page.
 *
 * Run with:
 *   mvn compile
 *   mvn exec:java -Dexec.mainClass="Sprint_38.ProgressApiServer"
 *
 * Or run the class directly from your IDE.
 */
public class ProgressApiServer {

    public static void main(String[] args) throws Exception {
        int port = 8080;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RootHandler());
        server.createContext("/api/progress", new ProgressHandler());
        server.setExecutor(Executors.newFixedThreadPool(4));

        System.out.println("Starting Progress API server on http://localhost:" + port);
        server.start();
    }

    private static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String html = "<!doctype html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "  <meta charset=\"utf-8\">\n" +
                    "  <title>Sample API Progress</title>\n" +
                    "  <style>\n" +
                    "    body { font-family: system-ui, sans-serif; margin: 2rem; }\n" +
                    "    .card { max-width: 600px; border: 1px solid #ddd; padding: 1.25rem; border-radius: 8px; }\n" +
                    "    .progress { width: 100%; background-color: #f1f1f1; border-radius: 4px; overflow: hidden; margin-top: 0.75rem; }\n" +
                    "    .bar { height: 22px; background: linear-gradient(90deg, #4caf50, #81c784); width: 3%; transition: width 0.4s ease; }\n" +
                    "    .meta { font-size: 0.9rem; color: #555; }\n" +
                    "  </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "  <div class=\"card\">\n" +
                    "    <h1>Sample API Progress</h1>\n" +
                    "    <p class=\"meta\">This page polls <code>/api/progress</code> every 2 seconds.</p>\n" +
                    "    <div class=\"progress\"><div id=\"bar\" class=\"bar\"></div></div>\n" +
                    "    <p id=\"status\">Loading...</p>\n" +
                    "    <pre id=\"json\" style=\"background:#f9f9f9;padding:0.75rem;border-radius:4px;overflow:auto;\"></pre>\n" +
                    "  </div>\n" +
                    "  <script>\n" +
                    "    async function refresh() {\n" +
                    "      try {\n" +
                    "        const res = await fetch('/api/progress');\n" +
                    "        const data = await res.json();\n" +
                    "        const pct = Math.max(0, Math.min(100, data.progress || 0));\n" +
                    "        document.getElementById('bar').style.width = pct + '%';\n" +
                    "        document.getElementById('status').textContent = `Task: ${data.task} — ${data.status} (${pct}%)`;\n" +
                    "        document.getElementById('json').textContent = JSON.stringify(data, null, 2);\n" +
                    "      } catch (err) {\n" +
                    "        document.getElementById('status').textContent = 'Error fetching progress: ' + err;\n" +
                    "      }\n" +
                    "    }\n" +
                    "    refresh();\n" +
                    "    setInterval(refresh, 2000);\n" +
                    "  </script>\n" +
                    "</body>\n" +
                    "</html>";

            byte[] bytes = html.getBytes("UTF-8");
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }

    private static class ProgressHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Map<String, Object> response = computeProgress();
            String json = toJson(response);

            Headers headers = exchange.getResponseHeaders();
            headers.set("Content-Type", "application/json; charset=utf-8");
            byte[] bytes = json.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }

        private Map<String, Object> computeProgress() {
            long now = Instant.now().toEpochMilli();
            long cycleMs = 30_000;
            int progress = (int) ((now % cycleMs) * 100 / cycleMs);

            Map<String, Object> output = new HashMap<>();
            output.put("task", "Demo task");
            output.put("progress", progress);
            output.put("status", progress < 100 ? "In progress" : "Complete");
            output.put("updatedAt", Instant.now().toString());
            return output;
        }

        private String toJson(Map<String, Object> map) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            boolean first = true;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!first) {
                    sb.append(",");
                }
                first = false;
                sb.append("\n  \"").append(entry.getKey()).append("\": ");
                Object value = entry.getValue();
                if (value instanceof Number || value instanceof Boolean) {
                    sb.append(value);
                } else {
                    sb.append("\"").append(String.valueOf(value).replace("\"", "\\\"")).append("\"");
                }
            }
            sb.append("\n}");
            return sb.toString();
        }
    }
}
