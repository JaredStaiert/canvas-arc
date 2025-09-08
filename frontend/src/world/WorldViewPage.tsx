import { useState } from 'react';
import { useQuery } from '@tanstack/react-query';
import { useParams } from 'react-router-dom';
import { Flex, Tabs } from '@mantine/core';
import { getWorldToEditById } from '@/api/world_api';

function WorldViewPage() {
  const { worldID } = useParams();

  const [activeTab, setActiveTab] = useState<string | null>('first');

  const query = useQuery({ queryKey: ['worldByID', { worldID }], queryFn: getWorldToEditById });

  return (
    <>
      <Flex justify="flex-start">
        <Tabs value={activeTab} onChange={setActiveTab}>
          <Tabs.List>
            <Tabs.Tab value="first">First tab</Tabs.Tab>
            <Tabs.Tab value="second">Second tab</Tabs.Tab>
          </Tabs.List>

          <Tabs.Panel value="first">First panel</Tabs.Panel>
          <Tabs.Panel value="second">Second panel</Tabs.Panel>
        </Tabs>
      </Flex>
    </>
  );
}

export default WorldViewPage;
