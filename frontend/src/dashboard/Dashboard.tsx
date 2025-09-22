import { Grid, Paper, RingProgress, Stack, Title } from "@mantine/core";

function Dashboard() {
  return (
    <>
      <Grid>
        <Grid.Col span={4}>
          <Paper shadow="lg" withBorder>
            <Stack>
              <Title order={3}>Title</Title>
                <DataTypeBreakdown/>
            </Stack>
          </Paper>
        </Grid.Col>
      </Grid>
    </>
  );
}

function DataTypeBreakdown() {
  return (
    <>
      <RingProgress
        size={200}
        thickness={22}
        sections={[
          { value: 40, color: "cyan", tooltip: "Characters" },
          { value: 15, color: "orange", tooltip: "Worlds" },
          { value: 15, color: "grape", tooltip: "Timelines" },
        ]}
      />
    </>
  );
}

export default Dashboard;
